CREATE OR REPLACE TRIGGER aur_emp
AFTER UPDATE OF salary
ON employees
FOR EACH ROW
DECLARE

BEGIN
	IF :NEW.salary > :OLD.salary * 1.05 THEN
		RAISE_APPLICATION_ERROR(-20000, 'Loonsverhoging met meer dan 5% is niet toegelaten');
	ELSIF :NEW.salary < :OLD.salary THEN
		RAISE_APPLICATION_ERROR(-20000, 'Loonsverlaging mag in geen enkel geval!');
	END IF;
END;
/