package src.main.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "todolistitem")
public class ToDoListItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toDoListItemId;


    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_description", nullable = false)
    private String itemDescription;

    @Column(name = "item_deadline", nullable = false)
    private Date itemDeadline;

    @Column(name = "item_status", nullable = false) //completed , not completed, expired
    private String itemStatus;

    @Column(name = "item_create_date", nullable = false)
    private Date itemCreateDate;


    @ManyToOne
    @JoinColumn(name = "toDoList_id", referencedColumnName = "toDoList_id")
    private ToDoListItem toDoListId;


    public Long getToDoListItemId() {
        return toDoListItemId;
    }

    public void setToDoListItemId(Long toDoListItemId) {
        this.toDoListItemId = toDoListItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Date getItemDeadline() {
        return itemDeadline;
    }

    public void setItemDeadline(Date itemDeadline) {
        this.itemDeadline = itemDeadline;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getItemCreateDate() {
        return itemCreateDate;
    }

    public void setItemCreateDate(Date itemCreateDate) {
        this.itemCreateDate = itemCreateDate;
    }

    public ToDoListItem getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(ToDoListItem toDoListId) {
        this.toDoListId = toDoListId;
    }

}


