package com.elw_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_video")
    private int idVideo;

    @Column(name = "ten_video", nullable = false)
    private String tenVideo;

    @Column(name = "duong_dan_video", nullable = false)
    private String duongDanVideo;

    @Column(name = "bai_hoc_ID", nullable = false)
    private int baiHocId;

    @Column(name = "status")
    private boolean status = true;

    // Getters, setters
    public int getIdVideo() { return idVideo; }
    public void setIdVideo(int idVideo) { this.idVideo = idVideo; }
    public String getTenVideo() { return tenVideo; }
    public void setTenVideo(String tenVideo) { this.tenVideo = tenVideo; }
    public String getDuongDanVideo() { return duongDanVideo; }
    public void setDuongDanVideo(String duongDanVideo) { this.duongDanVideo = duongDanVideo; }
    public int getBaiHocId() { return baiHocId; }
    public void setBaiHocId(int baiHocId) { this.baiHocId = baiHocId; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}