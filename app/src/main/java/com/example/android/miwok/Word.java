package com.example.android.miwok;

/**
 * Faz a traducao de Miwok para a lingua selecionada no android
 */

class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Construtor para traducao e palavra na lingua nativa
     * @param defaultTranslation A palavra a ser mostrada na lingua nativa do usuario
     * @param miwokTranslation A Traducao na lingua Miwok
     */
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Construtor que adiciona uma imagem e dois campos de texto
     * @param defaultTranslation A palavra a ser mostrada na lingua nativa do usuario
     * @param miwokTranslation A Traducao na lingua Miwok
     * @param imageResourceId Imagem relacionada a traducao
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }

    /**
     *
     * @return A palavra na lingua nativa do usuario
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     *
     * @return A palavra na lingua Miwok
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     *
     * @return A imagem relativa a palavra
     */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
