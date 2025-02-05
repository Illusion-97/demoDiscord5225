package ad.ya.demodiscord.bank;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Member;

@Getter
@RequiredArgsConstructor
public class Account {
    private final Member owner;
    private double solde;
}
