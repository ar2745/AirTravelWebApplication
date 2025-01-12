package com.example.airtravelwebapp.util;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.model.Users;

/**
 * Utility class for handling XML operations.
 */
public class XMLUtil {
    private static final Logger logger = LoggerFactory.getLogger(XMLUtil.class);

    /**
     * Reads users from the XML file.
     * 
     * @param filePath the path to the XML file
     * @return list of users
     */
    public static List<User> readUsersFromXML(String filePath) {
        try {
            // Create a File object for the XML file
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                logger.warn("XML file does not exist: {}", filePath);
                return List.of(); // Return empty list if file does not exist
            }

            // Create JAXB context and unmarshaller
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal the XML file to Users object
            Users users = (Users) unmarshaller.unmarshal(xmlFile);
            return users.getUsers();
        } catch (JAXBException e) {
            logger.error("Error reading users from XML", e);
            return List.of();
        }
    }

    /**
     * Writes users to the XML file.
     * 
     * @param users list of users to write
     * @param filePath the path to the XML file
     */
    public static void writeUsersToXML(List<User> users, String filePath) {
        try {
            // Create JAXB context and marshaller
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Create Users object and set the list of users
            Users usersWrapper = new Users();
            usersWrapper.setUsers(users);

            // Marshal the Users object to the XML file
            marshaller.marshal(usersWrapper, new File(filePath));
        } catch (JAXBException e) {
            logger.error("Error writing users to XML", e);
        }
    }
}