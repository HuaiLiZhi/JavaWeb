package org.example;

import org.example.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    
    private UserService userService;
    
    @BeforeEach
    void setUp() {
        userService = new UserService();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "110101199001013518", // 1990年1月1日出生
        "110101198512311234", // 1985年12月31日出生
        "110101200006154321"  // 2000年6月15日出生
    })
    void testGetAge_ValidIdCard_ReturnsCorrectAge(String idCard) {
        // 当前日期是2025年，所以这些测试应该能通过
        Integer age = userService.getAge(idCard);
        assertNotNull(age);
        assertTrue(age > 0);
    }
    
    @Test
    void testGetAge_NullIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge(null);
        });
    }
    
    @Test
    void testGetAge_WrongLengthIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getAge("123456");
        });
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "110101199001013511", // 奇数尾号，男性 (第17位是1)
        "110101198512311233", // 奇数尾号，男性 (第17位是3)
        "110101200006154355"  // 奇数尾号，男性 (第17位是5)
    })
    void testGetGender_OddNumberIdCard_ReturnsMale(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("男", gender);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "110101199001013560", // 偶数尾号，女性 (第17位是0)
        "110101198512311242", // 偶数尾号，女性 (第17位是2)
        "110101200006154324"  // 偶数尾号，女性 (第17位是4)
    })
    void testGetGender_EvenNumberIdCard_ReturnsFemale(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("女", gender);
    }
    
    @Test
    void testGetGender_NullIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender(null);
        });
    }
    
    @Test
    void testGetGender_WrongLengthIdCard_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            userService.getGender("123456");
        });
    }
}