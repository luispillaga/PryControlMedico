package com.medico.app.web.firebase;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

//    @Scheduled(cron = "0 */1 * * * ?")
//@RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> send() throws JSONException {

        JSONObject body = new JSONObject();
//        body.put("to", "/topics/" + TOPIC);
        body.put("to", "e-1jIZAODSc:APA91bG97CpZtLTlJmjwo1Q73YTT07Itkxatu9LblaFCLdGP9cPgcobS85R7s9qlxFAFnCDiVR2rID5Qboz3V-Swn5LBguUsSZylrdrH6vPhPJm4qP1VtVKOT4cuB25p1vcz1C5g4ZfL");
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "Informe Pacientes");
        notification.put("body", "Revisar la medicina de los pacientes");

        JSONObject data = new JSONObject();
        data.put("medicamento", "Recuerda darle el medicamento a todos tus pacientes");
        data.put("click_action", "FLUTTER_NOTIFICATION_CLICK");

        body.put("notification", notification);
        body.put("data", data);

/**
 {
 "notification": {
 "title": "JSA Notification",
 "body": "Happy Message!"
 },
 "data": {
 "medicamento": "Aspirina",
 },
 "to": "FCM Token",
 "priority": "high"
 }
 */

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
