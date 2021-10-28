package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Responsible for loading and saving data.
 */
public class FileHandler implements Persistence {

  private MemberRegistry registry;

  public FileHandler(MemberRegistry registry) {
    this.registry = registry;
  }

  @Override
  public void load() {
    FileReader file;
    String currentDir = System.getProperty("user.dir");
    try {
      ObjectMapper mapper = new ObjectMapper();
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      file = new FileReader(currentDir + "/files/data.json");
      ArrayList<Member> members = mapper.readValue(file, new TypeReference<ArrayList<Member>>(){});
      for(Member m : members) {
        registry.addMemberToRegistry(m);
      }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  @Override
  public void save() {
    ArrayList<Member> members = registry.getAllMembers();
    ObjectMapper mapper = new ObjectMapper();
    String currentDir = System.getProperty("user.dir");
    try {
      FileWriter file = new FileWriter(currentDir + "/files/data.json");
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, members);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
