package controller;

import model.MemberRegistry;

/**
 * A search strategy interface.
 */
public interface SearchStrategy {

  void search(MemberRegistry memberRegistry);
}
