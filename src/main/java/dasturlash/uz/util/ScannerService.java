package dasturlash.uz.util;

import dasturlash.uz.container.ComponentContainer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerService {
    private ComponentContainer componentContainer;

    public int getAction() {
        System.out.print("Enter action: ");
        try {
            return componentContainer.getScannerNumber().nextInt();
        } catch (InputMismatchException e) {
            componentContainer.setScannerNumber(new Scanner(System.in));
            System.out.println("\nPlease enter number.\n");
            return -1;
        }
    }

    public void setComponentContainer(ComponentContainer componentContainer) {
        this.componentContainer = componentContainer;
    }
}
