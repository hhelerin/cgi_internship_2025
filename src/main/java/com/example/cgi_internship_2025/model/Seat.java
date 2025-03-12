package com.example.cgi_internship_2025.model;

import com.example.cgi_internship_2025.EReclineType;
import com.example.cgi_internship_2025.ESeatClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private ESeatClass seatClass;
    @NotNull
    @Column(nullable = false)
    @Size(max = 128)
    private String name;
    @NotNull
    @Column(name = "is_window_seat", nullable = false)
    @NotNull
    private Boolean window;
    @NotNull
    @Column(name = "is_aisle_seat", nullable = false)
    @NotNull
    private Boolean aisle;
    @NotNull
    private EReclineType reclineType;
    @NotNull
    @Column(name = "emergency_exit", nullable = false)
    private Boolean emergencyExit;
    @Column(name = "has_tv", nullable = false)
    @NotNull
    private Boolean tv;
    @Column(name = "has_power_port", nullable = false)
    @NotNull
    private Boolean powerPort;
    @NotNull
    @Column(name = "has_baby_bassinet", nullable = false)
    private Boolean babyBassinet;
    @Size(max = 128)
    @Column(name = "additional_info")
    private String additionalInfo;
}
