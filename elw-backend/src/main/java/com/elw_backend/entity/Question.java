package com.elw_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cau_hoi")
    private int idCauHoi;

    @Column(name = "noi_dung_cau_hoi", nullable = false)
    private String noiDungCauHoi;

    @Column(name = "dap_an_dung", nullable = false)
    private String dapAnDung;

    @Column(name = "bai_kiem_tra_ID", nullable = false)
    private int baiKiemTraId;

    @Column(name = "dap_an_a", nullable = false)
    private String dapAnA;

    @Column(name = "dap_an_b", nullable = false)
    private String dapAnB;

    @Column(name = "dap_an_c", nullable = false)
    private String dapAnC;

    @Column(name = "dap_an_d", nullable = false)
    private String dapAnD;

    @Column(name = "status")
    private boolean status = true;

    // Getters, setters
    public int getIdCauHoi() { return idCauHoi; }
    public void setIdCauHoi(int idCauHoi) { this.idCauHoi = idCauHoi; }
    public String getNoiDungCauHoi() { return noiDungCauHoi; }
    public void setNoiDungCauHoi(String noiDungCauHoi) { this.noiDungCauHoi = noiDungCauHoi; }
    public String getDapAnDung() { return dapAnDung; }
    public void setDapAnDung(String dapAnDung) { this.dapAnDung = dapAnDung; }
    public int getBaiKiemTraId() { return baiKiemTraId; }
    public void setBaiKiemTraId(int baiKiemTraId) { this.baiKiemTraId = baiKiemTraId; }
    public String getDapAnA() { return dapAnA; }
    public void setDapAnA(String dapAnA) { this.dapAnA = dapAnA; }
    public String getDapAnB() { return dapAnB; }
    public void setDapAnB(String dapAnB) { this.dapAnB = dapAnB; }
    public String getDapAnC() { return dapAnC; }
    public void setDapAnC(String dapAnC) { this.dapAnC = dapAnC; }
    public String getDapAnD() { return dapAnD; }
    public void setDapAnD(String dapAnD) { this.dapAnD = dapAnD; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}