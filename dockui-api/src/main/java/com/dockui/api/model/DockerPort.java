package com.dockui.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * @author Hritik Chaudhary
 */
@Entity
public class DockerPort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String ip;

    @Getter
    @Setter
    private int privatePort;

    @Getter
    @Setter
    private int publicPort;

    @Getter
    @Setter
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    @Getter
    @Setter
    @JsonIgnore
    private Worker worker;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DockerPort)) return false;
        DockerPort that = (DockerPort) o;
        return privatePort == that.privatePort;
    }

    @Override
    public int hashCode() {
        return Objects.hash(privatePort);
    }
}
