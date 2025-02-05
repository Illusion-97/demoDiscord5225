package ad.ya.demodiscord.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

public class DemoBot extends ListenerAdapter {
    // Exécute du code quand le bot est "activé" sur un serveur
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        Guild guild = event.getGuild();
        guild.updateCommands()
                .addCommands(
                        Commands.slash("hello","Say hello"),
                        Commands.slash("tell", "repeat a sentence")
                                .addOption(OptionType.STRING, "text", "text to repeat", true)
                )
                .queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        // Nom de commande
        String commandName = event.getName();
        // Utilisateur qui a exécuté la commande
        Member author = event.getMember();

        /*event.reply(switch (commandName) {
            case "hello" -> "Hello World !";
            case "tell" -> "%s said %s".formatted(
                    author.getEffectiveName(),
                    event.getOption("text").getAsString()
            );
            default -> "Commande inconnue";
        }).queue();*/

        (switch (commandName) {
            case "hello" -> event.reply("Hello World !").setEphemeral(true);
            case "tell" -> event.reply("%s said %s".formatted(
                    author.getEffectiveName(),
                    event.getOption("text").getAsString()
            ));
            default -> event.reply("Commande inconnue");
        }).queue();

    }
}
