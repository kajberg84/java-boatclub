package model.persistence;

import model.MemberRegistry;

/**
 * Responsible for handling persistent data.
 */
public interface Persistence {
  public MemberRegistry load();

  public void save(MemberRegistry registry);
}
