package com.webapp6.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "company")
@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Company {
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Employee> employees;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name",unique = true)
    private String name;
    private int openyear;
    @Transient
    private int employeesSize;
    @Transient
    private double averageSalary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;

        if (id != company.id) return false;
        if (!Objects.equals(name, company.name)) return false;
        return openyear == company.openyear;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Objects.hashCode(name));
        result = 31 * result + openyear;
        return result;
    }
}
