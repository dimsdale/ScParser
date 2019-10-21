package com;

public final class  Constants {

    public static final String MAIN_PAGE = "https://www.aboutyou.de/maenner/bekleidung";
    //will be initialize on the start
    protected static int  QUANTITY_OF_PAGES;

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36";

    public static final String REFERRER = "http://www.google.com";

    public static final String TEMPLATE_OF_PAGE_WITH_PRODUCT_INFO = "https://www.aboutyou.de/p/%s/%s-%s";

    public static final String TEMPLATE_OF_REQUEST_TO_SERVER = "https://api-cloud.aboutyou.de/v1/products?with=attributes%%3Akey%%28brand%%7Cname%%29&filters%%5Bcategory%%5D=20290&sortDir=desc&sortScore=category_scores&sortChannel=etkp&page=%s&campaignKey=px&shopId=139";
}

