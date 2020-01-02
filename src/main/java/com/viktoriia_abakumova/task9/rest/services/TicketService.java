package com.viktoriia_abakumova.task9.rest.services;

import com.viktoriia_abakumova.task9.rest.responses.Response;

import lombok.extern.log4j.Log4j;
import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.Closeable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Log4j
public class TicketService {

    private static final String GET_AVAILABLE_TICKETS_URL = "http://10.23.149.167:9999/BookingTicket/getAvailableTicket.xml";
    private static final String BOOK_TICKET_URL = "http://10.23.149.167:9999/BookingTicket/bookTicket.json?user=1";

    public void downloadTicketsIntoFile(String filepath) throws MalformedURLException {
        URL url = new URL(GET_AVAILABLE_TICKETS_URL);
        try (InputStream inputStream = url.openStream(); Scanner scanner = new Scanner(inputStream); PrintWriter printWriter = new PrintWriter(new File(filepath))) {
            while (scanner.hasNext()) {
                printWriter.write(scanner.nextLine());
            }
        } catch (IOException e) {
            log.error(String.format("Can't download tickets into the file by path: %s", filepath), e);
        }
    }

    public Response bookTicketForUser(long ticketId, long userId) {
        DataOutputStream dataOutputStream = null;
        try {
            HttpsURLConnection httpsConnection = getHttpsURLConnection();

            dataOutputStream = new DataOutputStream(httpsConnection.getOutputStream());
            dataOutputStream.writeBytes("");

            return new Response(httpsConnection.getResponseMessage(),
                    httpsConnection.getResponseCode());

        } catch (IOException e) {
            log.error(String.format("Can't book a ticket id: %d, for user id: %d",
                    ticketId, userId), e);
        } finally {
            closeIOStream(dataOutputStream);
        }
        return new Response("Error", 500);
    }

    private HttpsURLConnection getHttpsURLConnection() throws IOException {
        URL url = new URL(BOOK_TICKET_URL);
        HttpsURLConnection httpsConnection = (HttpsURLConnection) url.openConnection();
        httpsConnection.setRequestMethod("POST");
        httpsConnection.setRequestProperty("Content-Type", "application/json");
        return httpsConnection;
    }

    private void closeIOStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                log.error("Can't close IOStream", e);
            }
        }
    }
}
