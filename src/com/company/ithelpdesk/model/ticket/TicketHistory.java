package com.company.ithelpdesk.model.ticket;

import com.company.ithelpdesk.enums.Status;

import java.util.Date;

public class TicketHistory {
    private long id;
    private Ticket ticket;
    private Comment comment;
    private Status status;
    private Date createdOn;

    public TicketHistory(long id, Ticket ticket, Comment comment, Status status, Date createdOn) {
        this.id = id;
        this.ticket = ticket;
        this.comment = comment;
        this.status = status;
        this.createdOn = createdOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
