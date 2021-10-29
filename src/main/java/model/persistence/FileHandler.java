package model.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import model.Member;
import model.MemberRegistry;

/**
 * Responsible for loading and saving data.
 */
public class FileHandler implements Persistence {
  @Override
  public MemberRegistry load() {
    MemberRegistry registry = new MemberRegistry();
    String currentDir = System.getProperty("user.dir");
    ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
      FileInputStream fileStream = new FileInputStream(currentDir + "/files/data.json");
      InputStreamReader file = new InputStreamReader(fileStream, "UTF-8");

      ArrayList<Member> members = mapper.readValue(file, new TypeReference<ArrayList<Member>>(){});
      for (Member m : members) {
        registry.addMemberToRegistry(m);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return registry;
  }

  @Override
  public void save(MemberRegistry registry) {    
    ArrayList<Member> members = registry.getAllMembers();
    ObjectMapper mapper = new ObjectMapper();
    String currentDir = System.getProperty("user.dir");
    try {
      FileOutputStream fileStream = new FileOutputStream(currentDir + "/files/data.json");
      OutputStreamWriter file = new OutputStreamWriter(fileStream, "UTF-8");
      mapper.writerWithDefaultPrettyPrinter().writeValue(file, members);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
