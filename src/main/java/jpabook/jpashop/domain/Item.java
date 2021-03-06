package jpabook.jpashop.domain;

import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public abstract class Item {
    @Id @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy="items")
    private List<Category> category;

    /*
     * 비즈니스 로직 *
     */
    /* 1. 재고 증가 */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /* 2. 재고 감소 */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity -= quantity;

        if (restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
