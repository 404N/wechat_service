package com.example.wechat.entity;

import javax.persistence.*;

@Table(name = "my_friends")
public class MyFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "my_user_id")
    private String myUserId;

    @Column(name = "my_friend_user_id")
    private String myFriendUserId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return my_user_id
     */
    public String getMyUserId() {
        return myUserId;
    }

    /**
     * @param myUserId
     */
    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }

    /**
     * @return my_friend_user_id
     */
    public String getMyFriendUserId() {
        return myFriendUserId;
    }

    /**
     * @param myFriendUserId
     */
    public void setMyFriendUserId(String myFriendUserId) {
        this.myFriendUserId = myFriendUserId;
    }
}