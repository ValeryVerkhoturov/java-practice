package com.company.practice3.game.objects;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public abstract class GameObject {

    public GameObject(@NonNull String name) {
        this.name = name;
    }

    @NonNull private String name;

    public char viewOnMap(){
        return 'U'; // Undefined
    }
}
