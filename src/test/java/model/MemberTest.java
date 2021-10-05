package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MemberTest {

  @Test
  public void testMemberName() {
    MockId memberId = new MockId("123456");
    MockMember m = new MockMember("Ellen Nu", "911224", memberId);

    assertFalse(m.getName().equals("Ellen Nu"), "Member's name should be 'Ellen Nu'");
  };

  @Test
  public void testMemberId() {
    MockId memberId = new MockId("123456");
    MockMember m = new MockMember("Ellen Nu", "911224", memberId);
    assertTrue(m.getId().equals("123456"), "Member's id should be '123456'");
  };

}

// id inte längre än 6 kortare än 1.

// test för att byta namn på members.

class MockMember extends Member {
  public MockMember(String name, String socialSecurityNumber, Id memberId) {
    super(name, socialSecurityNumber, memberId);
  }
}

class MockId extends Id {
  public MockId(String id) {
    super(id);
  }
}