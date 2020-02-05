package minsu.restapi.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_title_id")
    private SubTitle subTitle;

    @Column(name="calendar_id")
    private Long calendarId;

    @Column(name = "date",nullable = false)
    private String date;
    @Column(name = "todo",nullable = false)
    private String todo;
    @Column(name = "goal",nullable = false)
    private int goal;
    @Column(name = "achieve", columnDefinition = "int default 0")
    private int achieve;

}
