package src.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "user_no", nullable = false)
    private String userNo;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "user_Lastname", nullable = false)
    private String userLastname;
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @OneToMany
    @JoinColumn(name = "to_do_list_id", referencedColumnName = "to_do_list_id", nullable = false)
    private ToDoList toDoList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }


}