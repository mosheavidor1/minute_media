
package api_users.infra.api_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerActions {


    public static void startContainer() {
        // Execute "docker ps -a" command to get the container ID
        try {
            Process process = Runtime.getRuntime().exec("docker ps -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            boolean containerFound = false;
            String containerID = null;

            // Find the container ID
            while ((line = reader.readLine()) != null) {
                if (line.contains("CONTAINER ID")) {
                    continue;
                }

                String[] columns = line.split("\\s+");
                if (columns.length > 0) {
                    containerID = columns[0];
                    containerFound = true;
                    break;
                }
            }

            if (containerFound && containerID != null) {
                startContainer(containerID);
            } else {
                System.out.println("Container not found or no containers exist.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void stopContainer() {
        // Execute "docker ps -a" command to get the container ID
        try {
            Process process = Runtime.getRuntime().exec("docker ps -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            boolean containerFound = false;
            String containerID = null;

            // Find the container ID
            while ((line = reader.readLine()) != null) {
                if (line.contains("CONTAINER ID")) {
                    continue;
                }

                String[] columns = line.split("\\s+");
                if (columns.length > 0) {
                    containerID = columns[0];
                    containerFound = true;
                    break;
                }
            }

            if (containerFound && containerID != null) {
                stopContainer(containerID);
            } else {
                System.out.println("Container not found or no containers exist.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startContainer(String containerID) throws IOException {
        Process startProcess = Runtime.getRuntime().exec("docker start " + containerID);

    }

    private static void stopContainer(String containerID) throws IOException {
        Process stopProcess = Runtime.getRuntime().exec("docker stop " + containerID);

    }
}

