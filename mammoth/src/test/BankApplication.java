package test;

import java.util.Scanner;

import com.sun.glass.ui.Menu;

public class BankApplication {
	
	Account accountArray[] = new Account[500];
	Scanner scan = new Scanner(System.in);
	String input = "";
	
	public void menu() {
		int menu = 0;
		
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1. ���»���  |  2. ���¸��  |  3. ����  |  4. ���  |  5. ����");
			System.out.println("-----------------------------------------------------------");
			System.out.print("���� : ");
			input = scan.nextLine();
			if(!checkNumber(input)) {
				System.out.println("�߸��� �Է��Դϴ�.");
				continue;
			}
			menu = Integer.parseInt(input);
			switch (menu) {
			case 1:
				createAccount();
				break;
			case 2:
				viewAccountArray();
				break;
			case 3:
				deposit();
				break;
			case 4:
				withdraw();
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}
		}while(menu != 5);	
	}
	
	private boolean checkNumber(String input) {
		input = input.trim();
		for(int i =0 ; i < input.length() ; i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	private void withdraw() {
		Account account = null;
		String number = "";
		int withdrawAmount = 0;
		
		System.out.println("------------------------");
		System.out.println("���");
		System.out.println("------------------------");
		System.out.print("���¹�ȣ : ");
		number = scan.nextLine();
		account = findAccount(number);
		if(account != null) {
			System.out.print("��ݾ� : ");
			withdrawAmount = Integer.parseInt(scan.nextLine());			
			if(account.withdrawAccount(withdrawAmount) >= 0) {
				System.out.println("��� : ����� �����Ǿ����ϴ�.");
				System.out.println(account);
			}
		} else {
			System.out.println("�ùٸ��� ���� ���¹�ȣ�Դϴ�.");
		}
	}

	private void deposit() {
		Account account = null;
		String number = "";
		int depositAmount = 0;
		
		System.out.println("------------------------");
		System.out.println("�Ա�");
		System.out.println("------------------------");
		System.out.print("���¹�ȣ : ");
		number = scan.nextLine();
		account = findAccount(number);
		if(account != null) {
			System.out.print("���ݾ� : ");
			depositAmount = Integer.parseInt(scan.nextLine());
			account.depositAccount(depositAmount);
			System.out.println("��� : ������ �����Ǿ����ϴ�.");
			System.out.println(account);
		} else {
			System.out.println("�ùٸ��� ���� ���¹�ȣ�Դϴ�.");
		}
	}
	
	private Account findAccount(String number) {
		Account account = null;
		for(int i = 0; i<accountArray.length ; i++) {
			account = accountArray[i];
			if(account != null) {
				if(account.getnumber().equals(number)) {
					return account;
				}
			}
		}
		return account;
	}

	private void viewAccountArray() {
		Account account = null;
		System.out.println("------------------------");
		System.out.println("���¸��");
		System.out.println("------------------------");
		
		for(int i = 0; i<accountArray.length ; i++) {
			account = accountArray[i];
			if(account != null) {
				System.out.println(account.getnumber() + "\t" +account.getName() + "\t" + account.getBalance());
			} else {
				break;
			}
		}
	}
	

	private void createAccount() {
		String name = null;
		int balance = 0;
		int arrayIndex = 0;
		
		System.out.println("------------------------");
		System.out.println("���»���");
		System.out.println("------------------------");
		System.out.print("������ : ");
		name = scan.nextLine();
		System.out.print("�ʱ⿹�ݱݾ� : ");
		balance = Integer.parseInt(scan.nextLine());
		Account account = new Account(name, balance);
		arrayIndex = emptyAccountArray();
		accountArray[arrayIndex] = account;
		System.out.println("��� : ���°� �����Ǿ����ϴ�.");
		System.out.println(account);
	}
	
	private int emptyAccountArray() {
		for(int i = 0; i < accountArray.length ; i++) {
			if(accountArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. ���»��� 2. ���¸��  3. ����  4. ���  5. ����
		
		
		Account account1 = new Account("�Ⱥ���", 100000);
		Account account2 = new Account("�����", 10000);
		
		
		//System.out.println(account1);
		//System.out.println(account2);
		BankApplication ba = new BankApplication();
		ba.accountArray[0] = account1;
		ba.accountArray[1] = account2;
		
		ba.menu();
		
	}

}
