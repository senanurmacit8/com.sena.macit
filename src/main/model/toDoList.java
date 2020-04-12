package src.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "todolıst")
public class ToDoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toDoListId;
    @Column(name = "todolist_name", nullable = false)
    private String toDoListName;

    @Column(name = "dependedItem_Id", nullable = false) //başka todolistitem a bağımlılığı var mı
    private Long dependedItemId;

    @Column(name = "isCompleted", nullable = false)
    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

    @OneToMany
    @JoinColumn(name = "toDoListItem_id", referencedColumnName = "toDoListItem_id")
    private ToDoListItem toDoListItemId;


    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getToDoListName() {
        return toDoListName;
    }

    public void setToDoListName(String toDoListName) {
        this.toDoListName = toDoListName;
    }

    public Long getDependOnItem() {
        return dependedItemId;
    }

    public void setDependOnItem(Long dependOnItem) {
        dependedItemId = dependedItemId;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public ToDoListItem getToDoListItemId() {
        return toDoListItemId;
    }

    public void setToDoListItemId(ToDoListItem toDoListItemId) {
        this.toDoListItemId = toDoListItemId;
    }


}
