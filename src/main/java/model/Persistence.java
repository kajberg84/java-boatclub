package model;

/**
 * Responsible for handling persistent data.
 */
public interface Persistence {
  public void load();
  public void save();
}
