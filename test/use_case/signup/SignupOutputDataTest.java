package use_case.signup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupOutputDataTest {

    private SignupOutputData outputData;
    private final String expectedUsername = "testUser";
    private final boolean useCaseFailed = false; // This is not used in the current implementation

    @BeforeEach
    void setUp() {
        outputData = new SignupOutputData(expectedUsername, useCaseFailed);
    }

    @AfterEach
    void tearDown() {
        outputData = null;
    }

    @Test
    void getUsername() {
        // 测试 getUsername() 方法是否返回正确的用户名
        assertEquals(expectedUsername, outputData.getUsername());
    }

}
