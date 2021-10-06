// package controller;

// import static org.junit.jupiter.api.Assertions.assertTrue;
// import org.junit.jupiter.api.Test;
// import model.Id;

// public class MemberIdTest {

//   @Test
//   public void testMemberIdLength() {
//     MockIdHandler mockHandler = new MockIdHandler();
//     Id idString = mockHandler.generateUniqueId();
//     int length = idString.getId().length();

//     assertTrue(length < 7, "Length of id should be less than seven");
//   };
// }

// class MockIdHandler extends IdHandler {
//   public MockIdHandler() {
//     super();
//   }
// }