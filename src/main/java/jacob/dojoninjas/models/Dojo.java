package jacob.dojoninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //This will not all the createAt column to be updated after creation
        @Column(updatable=false)
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date created_at;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date updated_at;
        @OneToMany(mappedBy = "dojo", fetch=FetchType.LAZY)
        private List<Ninja> ninjas;

        public Dojo(){

        }


    public Dojo(Long id, String name, Date createdAt, Date updatedAt, List<Ninja> ninjas) {
        this.id = id;
        this.name = name;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
        this.ninjas = ninjas;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(Date createdAt) {
        this.created_at = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updated_at;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updated_at = updatedAt;
    }

    public List<Ninja> getNinjas() {
        return this.ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }


}
