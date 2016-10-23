package ua.com.vertex.util.io.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.vertex.util.io.UserReader;
import ua.com.vertex.util.vo.User;
import ua.com.vertex.util.vo.Users;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static ua.com.vertex.util.io.xml.XmlReader.getUsers;

/**
 * Created by sweet_home on 23.10.16.
 */
public class JsonUserReader implements UserReader {


    public List<User> readUsers(File jsonFile) {
        Users users;
        List<User> result = null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader fileReader = new FileReader(jsonFile)) {
            String json = new String(Files.readAllBytes(jsonFile.toPath()));

            result = gson.fromJson(json, Users.class).getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeUsers(File jsonFile, Users users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUsers = gson.toJson(users);

        System.out.println(jsonUsers);

        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            fileWriter.write(jsonUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Users users = getUsers();

        JsonUserReader reader = new JsonUserReader();
        File jsonFile = new File("/Users/sweet_home/IdeaProjects/vertex-crm/util/src/main/resources/json.txt");
        reader.writeUsers(jsonFile, users);

        List<User> usersFromJson = reader.readUsers(jsonFile);
        System.out.println(usersFromJson);
    }
}
