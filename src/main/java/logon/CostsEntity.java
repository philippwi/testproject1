package logon;

import javax.persistence.*;

@Entity
@Table(name = "costs", schema = "data", catalog = "")
public class CostsEntity {
  private String from;
  private String to;
  private int distance;
  private int id;
  private String user;

  @Basic
  @Column(name = "From")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  @Basic
  @Column(name = "To")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  @Basic
  @Column(name = "Distance")
  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "user")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CostsEntity that = (CostsEntity) o;

    if (distance != that.distance) return false;
    if (id != that.id) return false;
    if (from != null ? !from.equals(that.from) : that.from != null) return false;
    if (to != null ? !to.equals(that.to) : that.to != null) return false;
    if (user != null ? !user.equals(that.user) : that.user != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = from != null ? from.hashCode() : 0;
    result = 31 * result + (to != null ? to.hashCode() : 0);
    result = 31 * result + distance;
    result = 31 * result + id;
    result = 31 * result + (user != null ? user.hashCode() : 0);
    return result;
  }
}
