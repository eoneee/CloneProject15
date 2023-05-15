package com.example.cloneproject15.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomId;

    @Column(nullable = false)
    private String roomName;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    List<Chat> chatLists = new ArrayList<>();

    @Column(nullable = false, name = "host")
    private String host;

    public ChatRoom(String roomName, String host) {
        this.roomId = UUID.randomUUID().toString();
        this.roomName = roomName;
        this.host = host;
    }

}