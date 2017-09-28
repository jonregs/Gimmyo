package com.gimmyo.car.app.BidBoard.model;

/**
 * Created by Jon on 9/23/2017.
 */

public class GimmyoBidItem {

    private String bidOfferId;
    private String carManufacturer;
    private String carModel;
    private String carYear;
    private String bidOfferImage;
    private double bidAmount;
    private String targetUri;
    private int likes;
    private int dealerOffers;


    public GimmyoBidItem(String bidOfferId, String carManufacturer, String carModel, String carYear, String bidOfferImage, double bidAmount, String targetUri, int likes, int dealerOffers) {
        this.bidOfferId = bidOfferId;
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carYear = carYear;
        this.bidOfferImage = bidOfferImage;
        this.bidAmount = bidAmount;
        this.targetUri = targetUri;
        this.likes = likes;
        this.dealerOffers = dealerOffers;
    }

    public String getBidOfferId() {
        return bidOfferId;
    }

    public void setBidOfferId(String bidOfferId) {
        this.bidOfferId = bidOfferId;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getBidOfferImage() {
        return bidOfferImage;
    }

    public void setBidOfferImage(String bidOfferImage) {
        this.bidOfferImage = bidOfferImage;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDealerOffers() {
        return dealerOffers;
    }

    public void setDealerOffers(int dealerOffers) {
        this.dealerOffers = dealerOffers;
    }
}