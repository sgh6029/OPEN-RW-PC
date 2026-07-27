package com.corrodinggames.rts.gameFramework;

public enum AssetType
{
    gameImage("gameImage", 0), 
    gameImageCreate("gameImageCreate", 1), 
    gameImageColor("gameImageColor", 2), 
    gameImageFogBuffer("gameImageFogBuffer", 3), 
    gameFont("gameFont", 4), 
    gameSound("gameSound", 5), 
    uiImage("uiImage", 6);
    
    private static final /* synthetic */ AssetType[] h;
    
    
    private AssetType(final String name, final int ordinal) {
    }
    
    static {
        h = new AssetType[] { AssetType.gameImage, AssetType.gameImageCreate, AssetType.gameImageColor, AssetType.gameImageFogBuffer, AssetType.gameFont, AssetType.gameSound, AssetType.uiImage };
    }
}
