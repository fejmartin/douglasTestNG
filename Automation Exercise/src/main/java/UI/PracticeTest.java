package UI;

import POJO.Filters;
import PageObjects.MainPage;
import PageObjects.ParfumPage;
import csv.DataProviderClass;
import org.testng.annotations.Test;

public class PracticeTest extends TestSetup {
    MainPage mainPage;
    ParfumPage parfumPage;

    @Test(dataProvider = "getDataFromCSV", dataProviderClass = DataProviderClass.class)
    public void FiltersTest(Filters filters) throws InterruptedException {
         mainPage = new MainPage(driver);

        mainPage.acceptCookies();
        mainPage.navigateToParfumPage();

        parfumPage = new ParfumPage(driver);
        //Select filters
        parfumPage.verifyHighlightsMenu();
        parfumPage.clickOnHighlights();
        parfumPage.selectFilter(filters.getHighlights());
        parfumPage.verifyFilter(filters.getHighlights());

        parfumPage.clickOnMarke();
        parfumPage.selectFilter(filters.getMarke());
        parfumPage.verifyFilter(filters.getMarke());

        parfumPage.clickOnProduktart();
        parfumPage.selectFilter(filters.getProduktart());
        parfumPage.verifyFilter(filters.getProduktart());

        parfumPage.clickOnGeschenkFur();
        parfumPage.selectFilter(filters.getGeschenk_fur());
        parfumPage.verifyFilter(filters.getGeschenk_fur());

        parfumPage.clickOnFurWen();
        parfumPage.selectFilter(filters.getFur_Wen());
        parfumPage.verifyFilter(filters.getFur_Wen());


        // Verify Product List
        parfumPage.assertProductList(filters.getMarke(), filters.getProduktart(), filters.getHighlights());
    }
}
