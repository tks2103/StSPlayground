import basemod.interfaces.*;
import cards.Strike_Time;
import characters.TimeCharacter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.localization.RelicStrings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import patches.TimeEnum;
import relics.Chocolate;

import java.nio.charset.StandardCharsets;

@SpireInitializer
public class TimeClass implements PostBattleSubscriber, EditCharactersSubscriber, EditCardsSubscriber,
        EditRelicsSubscriber, EditStringsSubscriber {

    public static final Logger logger = LogManager.getLogger(TimeClass.class);

    private static final Color TIME_COLOR = CardHelper.getColor(90.0f, 90.0f, 100.0f);

    private TimeClass() {
        BaseMod.subscribe(this);

        BaseMod.addColor(TimeEnum.TimeColor,
                TIME_COLOR, TIME_COLOR, TIME_COLOR, TIME_COLOR, TIME_COLOR, TIME_COLOR, TIME_COLOR,
                "images/card/bg_attack_witch.png",
                "images/card/bg_skill_witch.png",
                "images/card/bg_power_witch.png",
                "images/card/card_witch_orb.png",
                "images/portrait/bg_attack_witch.png",
                "images/portrait/bg_skill_witch.png",
                "images/portrait/bg_power_witch.png",
                "images/portrait/card_witch_orb.png");
    }

    public static void initialize() {
        new TimeClass();
    }

    @Override
    public void receivePostBattle(AbstractRoom r) {
        System.out.println("Hey modder!");
    }

    @Override
    public void receiveEditCharacters() {
        logger.info("adding character");

        BaseMod.addCharacter(new TimeCharacter("TimeColor"),
                "images/button.png",
                "images/portrait.png",
                TimeEnum.TimeClass);
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike_Time());
    }

    @Override
    public void receiveEditRelics() {
        RelicLibrary.add(new Chocolate());
    }

    @Override
    public void receiveEditStrings() {
        String relicStrings = Gdx.files.internal("localization/Time-RelicStrings.json")
                .readString(String.valueOf(StandardCharsets.UTF_8));

        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
    }
}