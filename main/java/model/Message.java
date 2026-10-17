package model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Message {
private String sender;
private String content;
private LocalDateTime timestamp;

}
