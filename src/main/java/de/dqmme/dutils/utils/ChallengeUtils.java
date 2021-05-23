package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;

public class ChallengeUtils {
    public void setRandomItem(boolean randomItem) {
        DUtils.getPlugin(DUtils.class).challengesConf.set("Random-Item", randomItem);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).challengesConf, DUtils.getPlugin(DUtils.class).challenges);
    }

    public boolean getRandomItem() {
        return DUtils.getPlugin(DUtils.class).challengesConf.getBoolean("Random-Item");
    }
}
