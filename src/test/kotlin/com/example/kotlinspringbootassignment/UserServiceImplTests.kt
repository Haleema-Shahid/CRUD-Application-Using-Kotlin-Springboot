import com.example.kotlinspringbootassignment.dtos.UserDto
import com.example.kotlinspringbootassignment.entities.UserEntity
import com.example.kotlinspringbootassignment.enums.Role
import com.example.kotlinspringbootassignment.repositories.TeamRepository
import com.example.kotlinspringbootassignment.repositories.UserRepository
import com.example.kotlinspringbootassignment.services.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UserServiceImplTests {

    @Mock
    private lateinit var userRepository: UserRepository

    @Mock
    private lateinit var teamRepository: TeamRepository

    @InjectMocks
    private lateinit var userServiceImpl: UserService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test addUser`() {
        val userDto = UserDto(/* provide necessary userDto data */)
        val userEntity = UserEntity(/* provide necessary userEntity data */)

        `when`(userRepository.save(userEntity)).thenReturn(userEntity)

        userServiceImpl.addUser(userDto)

        verify(userRepository).save(userEntity)
    }

    @Test
    fun `test addAllUsers`() {
        val usersList = mutableListOf<UserEntity>(/* provide necessary userEntity data */)

        `when`(userRepository.saveAll(usersList)).thenReturn(usersList)

        userServiceImpl.addAllUsers(usersList)

        verify(userRepository).saveAll(usersList)
    }

    @Test
    fun `test assignRoles`() {
        // Mock data for teamRepository.findAll()
        val teams = listOf(null)
        `when`(teamRepository.findAll()).thenReturn(teams)

        // Mock data for userRepository.findById()
        val teamLeadId = UUID.randomUUID()
        val userEntity = UserEntity(id = teamLeadId, role = Role.DEVELOPER)
        `when`(userRepository.findById(teamLeadId)).thenReturn(Optional.of(userEntity))

        userServiceImpl.assignRoles()

        verify(userRepository).save(userEntity)
    }

    @Test
    fun `test assignTesterRoleTo`() {
        val userId = UUID.randomUUID()

        // Mock data for userRepository.findById()
        val userEntity = UserEntity(id = userId, role = Role.DEVELOPER)
        `when`(userRepository.findById(userId)).thenReturn(Optional.of(userEntity))

        // Mock data for userRepository.save()
        `when`(userRepository.save(userEntity)).thenReturn(userEntity)

        val result = userServiceImpl.assignTesterRoleTo(userId)

        verify(userRepository).save(userEntity)

        assertEquals(Role.TESTER, result.role)
    }
}
