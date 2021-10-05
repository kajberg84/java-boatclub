package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MemberTest {

  @Test
  public void testMemberName() {
    MockId memberId = new MockId("111111");
    MockMember m = new MockMember("Ellen Nu", "911224", memberId);

    assertTrue(m.getName().equals("Ellen Nu"), "Member's name is 'Ellen Nu'");
  };
}

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