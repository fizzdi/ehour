/*
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.rrm.ehour.domain;

// Generated Apr 7, 2007 1:08:18 AM by Hibernate Tools 3.2.0.beta8

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * MailLog generated by hbm2java
 */
@Entity
@Table(name = "MAIL_LOG")
@Cache(usage = CacheConcurrencyStrategy.NONE)
@Inheritance(strategy = InheritanceType.JOINED)
public class MailLog extends DomainObject<Integer, MailLog> {
    private static final long serialVersionUID = -3984593984762448559L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MAIL_LOG_ID")
    private Integer mailLogId;

    @ManyToOne
    @JoinColumn(name = "MAIL_TYPE_ID")
    @NotNull
    private MailType mailType;

    @ManyToOne
    @JoinColumn(name = "TO_USER_ID", nullable = true)
    private User toUser;

    @Column(name = "TIMESTAMP", nullable = false)
    @NotNull
    private Date timestamp;

    @Column(name = "SUCCESS", nullable = false)
    @Type(type = "yes_no")
    @NotNull
    private Boolean success = Boolean.TRUE;

    @Column(name = "MAIL_EVENT", length = 255)
    private String mailEvent;

    public MailLog() {
    }

    /**
     * full constructor
     */
    public MailLog(MailType mailType, User toUser, Date timestamp, Boolean success) {
        this.mailType = mailType;
        this.toUser = toUser;
        this.timestamp = timestamp;
        this.success = success;
    }

    // Property accessors

    public Integer getMailLogId() {
        return this.mailLogId;
    }

    public void setMailLogId(Integer mailLogId) {
        this.mailLogId = mailLogId;
    }

    public MailType getMailType() {
        return this.mailType;
    }

    public void setMailType(MailType mailType) {
        this.mailType = mailType;
    }

    public User getToUser() {
        return this.toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMailEvent() {
        return mailEvent;
    }

    public void setMailEvent(String about) {
        this.mailEvent = about;
    }

    @Override
    public Integer getPK() {
        return mailLogId;
    }

    public int compareTo(MailLog o) {
        return getTimestamp().compareTo(o.getTimestamp());
    }

    public boolean equals(Object object) {
        if (!(object instanceof MailLog)) {
            return false;
        }
        MailLog rhs = (MailLog) object;
        return new EqualsBuilder()
                .append(this.getTimestamp(), rhs.getTimestamp())
                .append(this.getToUser(), rhs.getToUser())
                .append(this.getMailLogId(), rhs.getMailLogId())
                .append(this.getSuccess(), rhs.getSuccess())
                .append(this.getMailType(), rhs.getMailType())
                .append(this.getMailEvent(), rhs.getMailEvent())
                .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(1202909165, -339864927)
                .append(this.getTimestamp())
                .append(this.getToUser())
                .append(this.getMailLogId())
                .append(this.getSuccess())
                .append(this.getMailType())
                .append(this.getMailEvent())
                .toHashCode();
    }

}
