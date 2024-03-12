package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Sport {

    private String id;
    private String name;
    private boolean active;
    private List<Competition> competitions;

    @Override
    public String toString() {
        return "Sport{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", competitions=" + competitions +
                '}';
    }
}