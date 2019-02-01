package characters;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpriterAnimation;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.red.Strike_Red;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.events.city.Vampires;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import patches.TimeEnum;

import java.util.ArrayList;

public class TimeCharacter extends CustomPlayer {

    public static final String[] orbTextures = null;
    public static final String orbVfxPath = null;

    public TimeCharacter (String name) {
        super(name,
                TimeEnum.TimeClass,
                orbTextures,
                orbVfxPath,
                new SpriterAnimation("animations/time.scml"));

        // required by core game
        this.dialogX = (this.drawX + 0.0F * Settings.scale);
        this.dialogY = (this.drawY + 220.0F * Settings.scale);

        initializeClass(null,
                "images/shoulder2.png",
                "images/shoulder.png",
                "images/corpse.png",
                getLoadout(),
                20.0F,
                -10.0F,
                220.0F,
                290.0F,
                new EnergyManager(3));
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo("TimeClass",
                "This is a Time Class",
                60,
                60,
                0,
                99,
                5,
                this,
                getStartingRelics(),
                getStartingDeck(),
                false);
    }

    @Override
    public ArrayList<String> getStartingRelics() {
        return new ArrayList<String>();
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        retVal.add("Strike_Time");
        return retVal;
    }

    @Override
    public String getTitle(PlayerClass playerClass) {
        return "TimeClass";
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return TimeEnum.Time;
    }

    @Override
    public Color getCardRenderColor() {
        return Color.SLATE;
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return new Strike_Red();
    }

    @Override
    public Color getCardTrailColor() {
        return Color.SLATE;
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 4;
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("BYRD_DEATH", 0.0f);
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "BYRD_DEATH";
    }

    @Override
    public String getLocalizedCharacterName() {
        return "Time Class";
    }

    @Override
    public AbstractPlayer newInstance() {
        return new TimeCharacter(this.name);
    }

    @Override
    public String getSpireHeartText() {
        return "OOOOH YEAH";
    }

    @Override
    public Color getSlashAttackColor() {
        return Color.SLATE;
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{AbstractGameAction.AttackEffect.BLUNT_HEAVY};
    }

    @Override
    public String getVampireText() {
        return Vampires.DESCRIPTIONS[5];
    }
}
