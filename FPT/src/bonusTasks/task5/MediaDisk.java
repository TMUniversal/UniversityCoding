package bonusTasks.task5;

import java.util.Date;

public class MediaDisk {
  private int id;
  private String title;
  private String director;
  private int publishYear;

  public MediaDisk(int id, String title, String director, int publishYear) {
    this.id = id;
    this.title = title;
    this.director = director;
    this.publishYear = publishYear;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public int getPublishYear() {
    return publishYear;
  }

  @Override
  public String toString() {
    return "MediaDisk{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", director='" + director + '\'' +
      ", year=" + publishYear +
      '}';
  }
}
