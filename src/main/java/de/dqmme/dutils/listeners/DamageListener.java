package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.ChallengeUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import de.dqmme.dutils.utils.Messages;
import de.dqmme.dutils.utils.TimerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DamageListener implements Listener {
    private final ChallengeUtils challengeUtils = new ChallengeUtils();
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final TimerUtils timerUtils = new TimerUtils();
    private final Messages messages = new Messages();

    public String damageCause;

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            double hearts = e.getDamage() / 2;

            e.setCancelled(!timerUtils.isRunning());

            if(timerUtils.isRunning()) {
                if(challengeUtils.getRandomEffect()) {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        Random random = new Random();
                        List<PotionEffectType> effects = Arrays.asList(PotionEffectType.values());
                        PotionEffectType randomEffect = effects.get(random.nextInt(effects.size()));
                        if (all.hasPotionEffect(randomEffect)) {
                            all.addPotionEffect(randomEffect.createEffect(999999999, all.getPotionEffect(randomEffect).getAmplifier()+1));
                            all.sendMessage(messages.EFFECT_ADDED.replace("%EFFECT%", randomEffect.getName()).replace("%LEVEL%", all.getPotionEffect(randomEffect).getAmplifier()+1 + ""));
                        } else {
                            all.addPotionEffect(randomEffect.createEffect(999999999, 0));
                            all.sendMessage(messages.EFFECT_ADDED.replace("%EFFECT%", randomEffect.getName()).replace("%LEVEL%", "1"));
                        }
                    }
                }
            }

            if(gameruleUtils.getSplitHealth()) {
                if(e.getCause() != EntityDamageEvent.DamageCause.CUSTOM) {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        all.damage(e.getDamage());
                        e.setCancelled(true);
                    }
                }
            }

            if(gameruleUtils.getDamageMessages()) {
                if(e.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
                    damageCause = "Explosion";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.CONTACT)) {
                    damageCause = "Kontakt";
                } else if (e.getCause().equals(EntityDamageEvent.DamageCause.CRAMMING)) {
                    damageCause = "zu viele Entitys";
                } else if (e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) {
                    if(gameruleUtils.getSplitHealth()) {
                        damageCause = null;
                    } else {
                        damageCause = "Eigen";
                    }
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.DRAGON_BREATH)) {
                    damageCause = "Drachenatem";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                    damageCause = "Ertrinken";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.DRYOUT)) {
                    damageCause = "Austrocknen";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                    damageCause = null;
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
                    damageCause = "Explosion [CREEPER]";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK)) {
                    damageCause = "Sweep-Attack";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                    damageCause = "Fallschaden";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.FALLING_BLOCK)) {
                    damageCause = "fallender Block";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
                    damageCause = "Feuer";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)) {
                    damageCause = "Verbrennen";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)) {
                    damageCause = "Ersticken";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.HOT_FLOOR)) {
                    damageCause = "Magma Block";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)) {
                    damageCause = "Lava";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.LIGHTNING)) {
                    damageCause = "Blitz";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.MAGIC)) {
                    damageCause = "Magie";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.MELTING)) {
                    damageCause = "Schmelzen";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.POISON)) {
                    damageCause = "Vergiftung";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
                    damageCause = "Projektil";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.STARVATION)) {
                    damageCause = "Verhungern";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.SUFFOCATION)) {
                    damageCause = "Ersticken";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.SUICIDE)) {
                    damageCause = "Selbstmord";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.THORNS)) {
                    damageCause = "Dornen";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    damageCause = "Void";
                } else if(e.getCause().equals(EntityDamageEvent.DamageCause.WITHER)) {
                    damageCause = "Wither";
                }
                if(damageCause != null) {
                    Bukkit.broadcastMessage(messages.DAMAGE_TAKEN.replace("%PLAYER%", player.getName()).replace("%CAUSE%", damageCause).replace("%DAMAGE%", hearts + ""));
                }
            }
        }
    }
}
