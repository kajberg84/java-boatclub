package model;

/**
 * Responsible for handling persistent data.
 */
public interface Persistence {
  public MemberRegistry load();

  public void save(MemberRegistry registry);
}
