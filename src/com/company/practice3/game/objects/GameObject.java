package com.company.practice3.game.objects;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public abstract class GameObject {

    @NonNull private String name;

    public GameObject(@NonNull String name) {
        this.name = name;
    }

    public char viewOnMap(){
        return 'U'; // Undefined
    }
}
